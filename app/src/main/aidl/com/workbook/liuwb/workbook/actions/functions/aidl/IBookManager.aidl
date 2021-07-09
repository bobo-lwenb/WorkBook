// IBookManager.aidl
package com.workbook.liuwb.workbook.actions.functions.aidl;
import com.workbook.liuwb.workbook.actions.functions.aidl.Book;
import com.workbook.liuwb.workbook.actions.functions.aidl.IOnNewBookArrivedListener;
// Declare any non-default types here with import statements

interface IBookManager {
    List<Book> getBookList();
    void addBook(in Book book);
    void registerListener(IOnNewBookArrivedListener listner);
    void unregisterListener(IOnNewBookArrivedListener listner);
}
