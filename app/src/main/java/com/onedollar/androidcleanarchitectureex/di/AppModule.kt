package com.onedollar.androidcleanarchitectureex.di

import com.onedollar.data.repository.TaskRepository
import com.onedollar.domain.usecase.DeleteTaskUseCase
import com.onedollar.domain.usecase.GetTaskListUseCase
import com.onedollar.domain.usecase.InsertTaskUseCase
import com.onedollar.domain.usecase.UpdateTaskUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
object AppModule {

    @Provides
    fun provideGetTaskListUseCase(repository: TaskRepository): GetTaskListUseCase {
        return GetTaskListUseCase(repository)
    }

    @Provides
    fun provideInsertTaskUseCase(repository: TaskRepository): InsertTaskUseCase {
        return InsertTaskUseCase(repository)
    }

    @Provides
    fun provideUpdateTaskUseCase(repository: TaskRepository): UpdateTaskUseCase {
        return UpdateTaskUseCase(repository)
    }

    @Provides
    fun provideDeleteTaskUseCase(repository: TaskRepository): DeleteTaskUseCase {
        return DeleteTaskUseCase(repository)
    }
}