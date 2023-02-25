package com.fawry.domain.interactor

import com.fawry.domain.models.Category
import com.fawry.domain.repository.EntriesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val entriesRepository: EntriesRepository,
) : BaseUseCase<Unit, Flow<List<Category>>> {

    override suspend operator fun invoke(params: Unit) = entriesRepository.getCategories()

}