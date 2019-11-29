// IOnNewBookArrivedListener.aidl
package com.workbook.liuwb.workbook.aidl;
import com.workbook.liuwb.workbook.aidl.Book;
// Declare any non-default types here with import statements

interface IOnNewBookArrivedListener {
    void onNewBookArrived(in Book book);
}
