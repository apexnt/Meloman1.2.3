const val PRICE_UNIT = 1000u
const val DISCOUNT_1LEVEL = 10u
const val DISCOUNT_2LEVEL = 5u

fun main() {
    println("Добро пожаловать в магазин музыкальных альбомов МЕЛОДИЯ !")
    println("Стоимость одного альбома $PRICE_UNIT руб.")
    print("Введите желаемое количество альбомов для покупки: ")
    val amountMelodies = readLine()?.toUInt() ?: return
    val subTotal = PRICE_UNIT * amountMelodies
    print("Сумма ваших покупок в прошлый месяц?: ")
    val amountPreviousPeriod = readLine()?.toUInt() ?: return
    print("Вы постоянный клиент? y - да, n - нет.")
    val vipUser: Boolean
    val checkVipUser = readLine()
    vipUser = checkVipUser == "y"
    val discountAmount = discount(amountPreviousPeriod, subTotal)
    val vipUserAmount = discountVip(discountAmount, vipUser)
    println("Сумма к оплате: $vipUserAmount руб.")
}

fun discount(amountPreviousPeriod: UInt, subTotal: UInt): UInt {
    var discountAmount = 0u
    if (amountPreviousPeriod <= 1_000u) discountAmount = subTotal
    else if (amountPreviousPeriod in 1_001u..10_000u) discountAmount = subTotal - DISCOUNT_1LEVEL
    else if (amountPreviousPeriod > 10_000u) discountAmount = subTotal - (subTotal * DISCOUNT_2LEVEL / 100u)
    return discountAmount
}

fun discountVip(discountAmount: UInt, vipUser: Boolean): UInt {
    return if (vipUser) discountAmount - (discountAmount / 100u)
    else discountAmount
}
