package edu.miu.BookCatalogClient;

import lombok.Data;

@Data
public class BookCopy {
    private String scanCode;
    private boolean available;

    public BookCopy(String scanCode, boolean available) {
        this.scanCode = scanCode;
        this.available = available;
    }
}
