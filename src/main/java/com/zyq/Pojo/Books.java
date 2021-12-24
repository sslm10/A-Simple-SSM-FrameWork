package com.zyq.Pojo;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Books {
    private int bookId;
    private String bookName;
    private String authorName;
    private int bookCounts;
    private String detail;
}