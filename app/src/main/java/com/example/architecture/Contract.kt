package com.example.architecture


interface IPresenter {
    fun sumClicked(a: String?, b: String?)
}

interface IView {
    fun showResult(result: Int)
    fun showInputError()
}
