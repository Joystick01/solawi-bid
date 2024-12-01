package org.solyton.solawi.bid.module.bid.component

import androidx.compose.runtime.Composable
import org.evoleq.compose.Markup
import org.evoleq.compose.date.format
import org.evoleq.language.Locale
import org.evoleq.optics.lens.FirstBy
import org.evoleq.optics.storage.Storage
import org.evoleq.optics.transform.times
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import org.solyton.solawi.bid.module.bid.data.Auction
import org.solyton.solawi.bid.module.bid.data.date
import org.solyton.solawi.bid.module.bid.data.name

@Markup
@Composable
@Suppress("FunctionName")
fun AuctionList(auctions: Storage<List<Auction>>, styles: AuctionListStyles = AuctionListStyles()) = Div(
    attrs = {style{styles.wrapper(this)}}
) {
    with(auctions.read()) {
        forEach{ auction ->
            AuctionListItem(auctions * FirstBy<Auction> { it.id == auction.id}, styles)
        }
    }
}

@Markup
@Composable
@Suppress("FunctionName")
fun AuctionListItem(auction: Storage<Auction>, styles: AuctionListStyles = AuctionListStyles()) = Div(attrs = {
    style { styles.item(this) }
}) {
    Div (attrs = {style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        width(80.percent)
    }}){
        // date
        Div(
            attrs = { style { width(20.percent) } }
        ) {
            val date = (auction * date).read()
            Text(date.format(Locale.De))
        }
        // name
        Div(attrs = { style { width(80.percent) } }) {
            val name = (auction * name).read()
            Text(name)
        }
    }
    Div(attrs = {style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        justifyContent(JustifyContent.End)
        width(20.percent)
    }}) {
        // Details
        Button(attrs = {
            style{

            }
            onClick {

            }
        }){
            Text("Details")
        }
        // Edit
        Button(attrs = {
            style{

            }
            onClick {

            }
        }){
            Text("Edit")
        }
        // Delete
        Button(attrs = {
            style{

            }
            onClick {

            }
        }){
            Text("Delete")
        }
    }
}

data class AuctionListStyles (
    val wrapper: StyleScope.()->Unit = {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        width(100.percent)
        height(100.percent)
        paddingTop(10.px)
        margin(5.px)

    },
    val item: StyleScope.()->Unit = {
        paddingTop(10.px)
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        width(100.percent)
    }
)
