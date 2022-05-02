package com.medina.pokertinker.Util

import android.view.ViewGroup
import android.view.View
import android.view.LayoutInflater


fun ViewGroup.inflate(layoutsRes: Int) : View =
    LayoutInflater.from(context).inflate(layoutsRes, this, false)
