package heenu.moon.yoon_memo_android.presentation.ui.home

import heenu.moon.yoon_memo_android.presentation.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import timber.log.Timber


class HomeViewModel : BaseViewModel() {

    private val _homeCovered = MutableStateFlow<Boolean>(true) // data store로 이관
    val homeCovered: StateFlow<Boolean>
        get() = _homeCovered


    // todo  input을 하나로 묶고 싶은데 좋은 방법 생각좀
    fun homeCoveredClick(checked:Boolean) {
        Timber.d("tag1 checed $checked")
        _homeCovered.value = !_homeCovered.value
        // todo data store에게 알려야함
    }

}