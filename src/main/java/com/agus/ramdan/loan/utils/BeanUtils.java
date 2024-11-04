package com.agus.ramdan.loan.utils;
// copy from https://ashokma.com/posts/Fix-org-springframework-beans-BeanUtils-ignore-null-values-on-copying-properties
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.beans.FatalBeanException;
import org.springframework.util.Assert;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BeanUtils
        extends org.springframework.beans.BeanUtils {

    public static void copyNonNullProperties(
            Object source, Object target
    ) {
        Assert.notNull(source, "Source must not be null");
        Assert.notNull(target, "Target must not be null");
        Class<?> actualEditable = target.getClass();
        PropertyDescriptor[] targetPds = getPropertyDescriptors(actualEditable);
        for (PropertyDescriptor targetPd : targetPds) {
            if (targetPd.getWriteMethod() != null) {
                PropertyDescriptor sourcePd = getPropertyDescriptor(source.getClass(), targetPd.getName());
                if (
                        sourcePd != null
                                && sourcePd.getReadMethod() != null
                ) {
                    try {
                        Method readMethod = sourcePd.getReadMethod();
                        if (
                                !Modifier.isPublic(
                                        readMethod.getDeclaringClass()
                                                .getModifiers())
                        ) {
                            readMethod.setAccessible(true);
                        }
                        Object value = readMethod.invoke(source);
                        // Ignore properties with null values.
                        if (value != null) {
                            Method writeMethod = targetPd.getWriteMethod();
                            if (
                                    !Modifier.isPublic(
                                            writeMethod.getDeclaringClass()
                                                    .getModifiers())
                            ) {
                                writeMethod.setAccessible(true);
                            }
                            writeMethod.invoke(target, value);
                        }
                    } catch (Throwable ex) {
                        throw new FatalBeanException(
                                "Could not copy properties from source to target", ex
                        );
                    }
                }
            }
        }
    }

}
