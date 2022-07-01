package com.github.architecturepetproject.di

import com.github.architecturepetproject.data.repository.RepositoryImp
import com.github.architecturepetproject.data.storage.SharedPrefUserStorage
import com.github.architecturepetproject.data.storage.UserStorage
import com.github.architecturepetproject.domain.repository.Repository
import org.koin.dsl.module

val dataModule = module {

    single<UserStorage> {
        SharedPrefUserStorage(context = get())
    }

    single<Repository> {
        RepositoryImp(userStorage = get())
    }

}