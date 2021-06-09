package com.onedollar.data.mapper

interface Mapper<in T, R> {
    fun map(t: T): R
}