// IBookManager.aidl
package com.workbook.liuwb.workbook.aidl;
import com.workbook.liuwb.workbook.aidl.Book;
import com.workbook.liuwb.workbook.aidl.IOnNewBookArrivedListener;
// Declare any non-default types here with import statements

interface IBookManager {
    List<Book> getBookList();
    void addBook(in Book book);
    void registerListener(IOnNewBookArrivedListener listner);
    void unregisterListener(IOnNewBookArrivedListener listner);
}
