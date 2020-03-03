package frc.team1923.robot.utilities.can;

import edu.wpi.first.hal.can.CANInvalidBufferException;
import edu.wpi.first.hal.can.CANJNI;
import edu.wpi.first.hal.can.CANMessageNotAllowedException;
import edu.wpi.first.hal.can.CANMessageNotFoundException;
import edu.wpi.first.hal.can.CANNotInitializedException;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class CANDeviceFinder {
    public enum DeviceType {
        PDP(0x8041400),
        PCM(0x9041400),
        TalonFX(0x2041000),
        SparkMax(0x2051800);

        private final int deviceID;

        private DeviceType(int deviceID) {
            this.deviceID = deviceID;
        }

        private static <T> Map<DeviceType, T> map(Function<DeviceType, T> mapper) {
            return Arrays.stream(DeviceType.values())
                         .map(deviceType -> Map.entry(deviceType, mapper.apply(deviceType)))
                         .collect(Collectors.toMap(Map.Entry<DeviceType, T>::getKey,
                                                   Map.Entry<DeviceType, T>::getValue));
        }
    }

    private CANDeviceFinder() {}

    public static Map<DeviceType, int[]> find() {
        Map<DeviceType, long[]> beforeTimeStamps = CANDeviceFinder.lastTimeStamps();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        Map<DeviceType, long[]> afterTimeStamps = CANDeviceFinder.lastTimeStamps();

        return DeviceType.map(deviceType -> {
            long[] before = beforeTimeStamps.get(deviceType);
            long[] after = afterTimeStamps.get(deviceType);

            return IntStream.range(0, 63).filter(i -> before[i] != after[i]).toArray();
        });
    }

    public static void find(Consumer<Map<DeviceType, int[]>> callback) {
        new Thread(() -> {
            callback.accept(CANDeviceFinder.find());
        }).start();
    }

    private static long lastTimeStamp(int deviceID) {
        IntBuffer messageID = ByteBuffer.allocateDirect(4).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        ByteBuffer timeStamp = ByteBuffer.allocateDirect(4).order(ByteOrder.LITTLE_ENDIAN);

        messageID.put(0, deviceID);

        try {
            CANJNI.FRCNetCommCANSessionMuxReceiveMessage(messageID, 0x1FFFFFFF, timeStamp);
        } catch (CANInvalidBufferException
               | CANMessageNotAllowedException
               | CANMessageNotFoundException
               | CANNotInitializedException e) {
            return 0;
        }

        return Integer.toUnsignedLong(timeStamp.getInt(0));
    }

    private static Map<DeviceType, long[]> lastTimeStamps() {
        return DeviceType.map(deviceType -> IntStream.range(0, 63)
                                                     .mapToLong(i -> CANDeviceFinder.lastTimeStamp(deviceType.deviceID | i))
                                                     .toArray());
    }
}
