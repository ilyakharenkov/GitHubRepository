package com.github.architecturepetproject.di

import com.github.architecturepetproject.domain.usecase.GetUserNameUseCase
import com.github.architecturepetproject.domain.usecase.SaveUserNameUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<GetUserNameUseCase> {
        GetUserNameUseCase(repository = get())
    }

    factory<SaveUserNameUseCase> {
        SaveUserNameUseCase(repository = get())
    }

}
