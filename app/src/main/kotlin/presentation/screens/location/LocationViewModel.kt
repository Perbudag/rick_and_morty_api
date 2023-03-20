package presentation.screens.location

import domain.usecase.repository.rick_and_morty.GetAllLocationsUseCase
import domain.usecase.repository.rick_and_morty.GetLocationUseCase
import domain.usecase.repository.rick_and_morty.GetLocationsUseCase
import javax.inject.Inject

class LocationViewModel @Inject constructor(
    val getAllLocationsUseCase: GetAllLocationsUseCase,
    val getLocationsUseCase: GetLocationsUseCase,
    val getLocationUseCase: GetLocationUseCase
) {

}