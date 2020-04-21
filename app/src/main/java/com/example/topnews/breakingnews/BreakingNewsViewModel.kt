package com.example.topnews.breakingnews

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.entities.ScreenState
import com.example.domain.usecases.GetBreakingNewsUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class BreakingNewsViewModel @Inject constructor(
    private val getBreakingNewsUseCase: GetBreakingNewsUseCase,
    private val compositeDisposable: CompositeDisposable
) : ViewModel() {

    private val _breakingNewsObservable: MutableLiveData<ScreenState> =
        MutableLiveData()
    val breakingNewsObservable: LiveData<ScreenState>
        get() = _breakingNewsObservable

    private fun getBreakingNews() {
        compositeDisposable.add(
            getBreakingNewsUseCase.getNews("gb")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { list ->
                        _breakingNewsObservable.value = list

                    }, { error ->
                        error.printStackTrace()
                    }
                )
        )
    }

    init {
        getBreakingNews()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}