package com.fawry.domain.interactor

import com.fawry.domain.models.Entry
import com.fawry.domain.repository.EntriesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetEntriesByCategoryUseCase @Inject constructor(
    private val entriesRepository: EntriesRepository,
) : BaseUseCase<String, Flow<List<Entry>>> {

    override suspend operator fun invoke(params: String) =
        entriesRepository.getEntriesByCategory(category = params)

}