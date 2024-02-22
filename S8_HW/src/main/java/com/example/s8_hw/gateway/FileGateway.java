package com.example.s8_hw.gateway;

import com.example.s8_hw.domain.Task;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;

/**
 * Интерфейс для записи данных в файл через Spring Integration.
 *
 * @author Nick
 * @version 1.0
 */
@MessagingGateway(defaultRequestChannel = "textInputChannel")
public interface FileGateway {

    /**
     * Метод для записи данных в файл.
     *
     * @param filename Имя файла.
     * @param data     Данные для записи.
     */
    void writeToFile(@Header(FileHeaders.FILENAME) String filename, Task data);
}
