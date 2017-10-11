package com.janloong.storage;

import org.springframework.stereotype.Component;

//@config("storage")
//@ConfigurationProperties("storage")
@Component
public class StorageProperties {

    /**
     * Folder location for storing files
     */
    //private String location = "upload-dir";
    private String location = "c:/Users/Administrator/Desktop/dir";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
