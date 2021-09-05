package com.light.hogwartslibrary.ui.scenes.house

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.light.hogwartslibrary.R

class HouseDetailViewModel : ViewModel() {

    private val _fonder = MutableLiveData<String>().apply { value = "" }
    private val _leader = MutableLiveData<String>().apply { value = "" }
    private val _houseName = MutableLiveData<String>().apply { value = "" }
    private val _houseImage = MutableLiveData<Int>().apply { value = R.drawable.griffindor }

    val fonder: LiveData<String> = _fonder
    val leader: LiveData<String> = _leader
    val houseName: LiveData<String> = _houseName
    val houseImage: LiveData<Int> = _houseImage

    fun fetchData(houses: Houses) {
        when (houses) {
            Houses.Griffindor -> {
                _fonder.postValue("Godrik Griffindor")
                _leader.postValue("McGonagal")
                _houseName.postValue("Griffindor")
                _houseImage.postValue(R.drawable.griffindor)
            }
            Houses.Hufflepuff -> {
                _fonder.postValue("Helga Hufflepuff")
                _leader.postValue("Pomona Stebel")
                _houseName.postValue("Hufflepuff")
                _houseImage.postValue(R.drawable.hufflepuff)
            }
            Houses.Ravenclaw -> {
                _fonder.postValue("Rowena Ravenclaw")
                _leader.postValue("Philius Phlitvik")
                _houseName.postValue("Ravenclaw")
                _houseImage.postValue(R.drawable.ravenclaw)
            }
            else -> {
                _fonder.postValue("Salasar Slytherin")
                _leader.postValue("Severus Snegg")
                _houseName.postValue("Slytherin")
                _houseImage.postValue(R.drawable.slytherin)
            }
        }
    }

}