package org.solyton.solawi.bid.module.bid.data.api

import kotlinx.serialization.Serializable


@Serializable
data class Bid(
    val username: String,
    val link: String,
    val amount: Double
)

@Serializable
data class NewBidder(
    val username: String,
    val weblingId: Int,
    val numberOfParts: Int
) {
    init {
       // if(numberOfParts < 0) throw BidRoundException.IllegalNumberOfParts(numberOfParts)
    }
}

@Serializable
data class Bidder(
    //@Serializable(with = UUIDSerializer::class)
    val id: String,
    val username: String,
    val weblingId: Int,
    val numberOfParts: Int,
    val bidRounds: List<BidRound> = listOf()
) {
    init {
       // if(numberOfParts < 0) throw BidRoundException.IllegalNumberOfParts(numberOfParts)
    }
}

@Serializable
data class  PreRound(
    //@Serializable(with = UUIDSerializer::class)
    val auctionId: String//Uuid,
)

@Serializable
data class  ChangeRoundState(
    //@Serializable(with = UUIDSerializer::class)
    val roundId: String,// Uuid,
    val state: String
) {
    init {
     //   if(!state.isValidRoundStateName()) throw BidRoundException.NoSuchRoundState(state)
    }
}

@Serializable
data class Round(
    //@Serializable(with = UUIDSerializer::class)
    val id: String,//Uuid,
    val link: String,
    val state: String
)

@Serializable
data class PreAuction(
    val name: String
)

@Serializable
data class Auction(
    //@Serializable(with = UUIDSerializer::class)
    val id: String,
    val name: String,
    val rounds: List<Round> = listOf(),
    val bidderIds: List</*@Serializable(with = UUIDSerializer::class) Uuid*/ String> = listOf()
)

@Serializable
data object GetAuctions

@Serializable
data class Auctions(
    val list: List<Auction> = listOf()
)

@Serializable
data class BidRound(
    //@Serializable(with = UUIDSerializer::class)
    val id: String, //Uuid, //= ZeroUUID,
    val round: Round,
    val auction: Auction,
    val amount: Double?
)

