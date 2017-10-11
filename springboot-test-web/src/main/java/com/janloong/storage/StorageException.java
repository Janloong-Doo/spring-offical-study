package com.janloong.storage;

/**
 * @author Janloong
 * @create 2017-10-10 11:13
 **/
public class StorageException extends RuntimeException {

    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
