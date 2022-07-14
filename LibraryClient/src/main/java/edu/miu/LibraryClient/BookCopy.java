package edu.miu.LibraryClient;

import lombok.Data;

@Data
public class BookCopy {
    private String scanCode;
    private boolean available;
}
