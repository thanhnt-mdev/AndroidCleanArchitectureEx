package com.onedollar.androidcleanarchitectureex.di

import android.content.Context
import com.onedollar.data.database.TaskDatabase
import com.onedollar.data.repository.TaskRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {
    @Provides
    fun provideRepository(database: TaskDatabase): TaskRepository {
        return TaskRepository(database)
    }

    @Provides
    @Singleton
    fun provideTaskDatabase(@ApplicationContext context: Context): TaskDatabase {
        return TaskDatabase.getDatabase(context)
    }
}