package com.example.talentomobiletechtest.common.view.adapter.dw

import android.os.Parcelable

abstract class BaseDataWrapper: Parcelable {
    abstract val viewType: Int
}