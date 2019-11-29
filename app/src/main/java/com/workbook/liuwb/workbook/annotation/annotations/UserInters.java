package com.workbook.liuwb.workbook.annotation.annotations;

import com.workbook.liuwb.workbook.annotation.model.DefModel;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import androidx.annotation.IntDef;

@IntDef({DefModel.childe, DefModel.girl, DefModel.man})
@Retention(RetentionPolicy.SOURCE)
public @interface UserInters {
}
