package kr.co.donghyun.covid19_.presentation.base

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kr.co.donghyun.covid19_.presentation.utils.SingleLiveEvent
import kotlin.reflect.KClass

open class BaseViewModel : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    val isRefreshing = MutableLiveData(false)

    private val _eventSpecialActivity = SingleLiveEvent<String>()
    private val _eventMyActivity = SingleLiveEvent<Pair<KClass<*>, Bundle?>>()
    private val _eventMyFragment = SingleLiveEvent<Int>()

    val startNavigate: MutableLiveData<Int>
        get() = _eventMyFragment
    val startActivity: MutableLiveData<Pair<KClass<*>, Bundle?>>
        get() = _eventMyActivity
    val startWebActivity: MutableLiveData<String>
        get() = _eventSpecialActivity

    fun addDisposable(single: Single<*>, observer: DisposableSingleObserver<*>) {
        compositeDisposable.add(single.subscribeOn(Schedulers.io()).
        observeOn(AndroidSchedulers.mainThread()).subscribeWith(observer as SingleObserver<Any>) as Disposable)
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}