package heenu.moon.yoon_memo_android.presentation.ui.home

import heenu.moon.yoon_memo_android.presentation.base.BaseViewModel
import heenu.moon.yoon_memo_android.presentation.ui.fake.datas.mockHomeMemoList12
import heenu.moon.yoon_memo_android.presentation.ui.fake.datas.mockHomeMemoList1Short
import heenu.moon.yoon_memo_android.presentation.ui.model.Memo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import timber.log.Timber


class HomeViewModel : BaseViewModel() {

    private val _homeCovered = MutableStateFlow<Boolean>(false) // data store로 이관
    val homeCovered: StateFlow<Boolean>
        get() = _homeCovered


    private val _memoList = MutableStateFlow<List<Memo>>(mockHomeMemoList12()) // data store로 이관
    val memoList: StateFlow<List<Memo>>
        get() = _memoList

    // todo  input을 하나로 묶고 싶은데 좋은 방법 생각좀
    fun homeCoveredClick(checked: Boolean) {
        Timber.d("tag1 checed $checked")
        _homeCovered.value = !_homeCovered.value
        // todo data store에게 알려야함
    }

}