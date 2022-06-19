package me.nickrest.command.system.command.data;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * The info of the Command
 * */
@Retention(RetentionPolicy.RUNTIME)
public @interface CommandInfo {
    String name();
    String permission() default "";
    boolean console() default false;
}
