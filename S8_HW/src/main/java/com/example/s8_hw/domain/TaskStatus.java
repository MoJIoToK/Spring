package com.example.s8_hw.domain;

/**
 * Класс TaskStatus является enum.
 *
 * @author Nick
 * @version 1.0
 */
public enum TaskStatus {

    NOT_STARTED("не начата"),
    IN_PROGRESS("в процессе"),
    COMPLETED("завершена!");

    private String displayStatus;
    TaskStatus(String displayStatus) {
        this.displayStatus = displayStatus;
    }

    public String getDisplayStatus() {
        return displayStatus;
    }
}
