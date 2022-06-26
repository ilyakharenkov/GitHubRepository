package com.github.architecturepetproject.domain.usecase

import com.github.architecturepetproject.domain.models.GetUserModels
import com.github.architecturepetproject.domain.repository.Repository

class GetUserNameUseCase(private val repository: Repository) {

        fun execute(): GetUserModels{
        return repository.getUser()
    }

}
