package com.example.architecture


class TextPresentation() {

    data class NumberView(val text:String, val number:Int?)

    fun checkNumChangePresent(newTxt: String, currentTxt: String) : NumberView{
        return try {
            NumberView(newTxt,newTxt.toInt())
        } catch (e: NumberFormatException) {
             if(newTxt.isEmpty()){
                NumberView("",null)
            }else{
                NumberView(currentTxt,currentTxt.toInt())
             }
        }
    }


}