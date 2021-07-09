// IOnNewBookArrivedListener.aidl
package com.workbook.liuwb.workbook.actions.functions.aidl;
import com.workbook.liuwb.workbook.actions.functions.aidl.Book;
// Declare any non-default types here with import statements

interface IOnNewBookArrivedListener {
    void onNewBookArrived(in Book book);
}
