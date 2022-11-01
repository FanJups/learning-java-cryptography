package org.example.cryptography;

import java.io.File;

public interface Constants {

    byte[] DATA = "This is a test".getBytes();

    File DATA_FILE = new File("encrypted.data");
    File KEY_FILE = new File("key.data");
}
