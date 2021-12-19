package kr.co.donghyun.covid19_.data

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

@Xml(name = "response")
data class Covid19ResultData(
    @Element
    val header : Header?,
    @Element
    val body: Body?,
)

@Xml(name = "header")
data class Header(
    @PropertyElement
    val resultCode: Int?,
    @PropertyElement
    val resultMsg: String?,
)

@Xml(name = "body")
data class Body(
    @Element
    val items: Items?,
    @PropertyElement
    val numOfRows: Int?,
    @PropertyElement
    val pageNo: Int?,
    @PropertyElement
    val totalCount: Int?,
)

@Xml
data class Items(
    @Element(name = "item")
    val item: List<Item>?
)

@Xml
data class Item(
    @PropertyElement(name="createDt") var createDt: String?,
    @PropertyElement(name="deathCnt") var deathCnt : Int?,
    @PropertyElement(name="defCnt") var defCnt : String?,
    @PropertyElement(name="gubun") var gubun : String?,
    @PropertyElement(name="gubunCn") var gubunCn: String?,
    @PropertyElement(name="gubunEn") var gubunEn: String?,
    @PropertyElement(name="incDec") var incDec: String?,
    @PropertyElement(name="isolClearCnt") var isolClearCnt: String?,
    @PropertyElement(name="localOccCnt") var localOccCnt: String?,
    @PropertyElement(name="overFlowCnt") var overFlowCnt: String?,
    @PropertyElement(name="qurRate") var qurRate: String?,
    @PropertyElement(name="seq") var seq: String?,
    @PropertyElement(name="stdDay") var stdDay: String?,
    @PropertyElement(name="updateDt") var updateDt: String?
){
    constructor() :
            this(null,null,null,null,
                    null,null,null,null, null, null,
                                                                null, null, null, null)
}