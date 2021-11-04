package frc.team1923.robot.utilities.motor.group;

import frc.team1923.robot.utilities.motor.ConfigurableMotor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;

public class Group<T extends ConfigurableMotor<T>> extends ConfigurableMotorGroup<T> {
    public Group(int leaderID, int... followerIDs) {
        super(leaderID, followerIDs);
    }

    private Constructor<T> getConstructor(Class<?>... parameterTypes) {
        ParameterizedType superclass = (ParameterizedType) this.getClass().getGenericSuperclass();

        @SuppressWarnings("unchecked")
        Class<T> typeArgument = (Class<T>) superclass.getActualTypeArguments()[0];

        try {
            return typeArgument.getConstructor(parameterTypes);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    private final Constructor<T> constructor = this.getConstructor(Integer.class, Boolean.class, Boolean.class);

    @Override
    protected T create(int deviceID) {
        try {
            return this.constructor.newInstance(deviceID, this.invert, !this.coast);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
