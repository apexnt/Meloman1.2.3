const val PRICE_UNIT = 1000u
const val DISCOUNT_1LEVEL = 100u
const val DISCOUNT_2LEVEL = 5u
const val TEXT_AMOUNT_TO_BE_PAID = "Сумма к оплате"
const val TEXT_RUB = "руб."

fun main() {
    val totalAmount: UInt
    val subTotalVipUser: UInt

    println("Добро пожаловать в магазин музыкальных альбомов МЕЛОДИЯ !")
    println("Стоимость одного альбома $PRICE_UNIT $TEXT_RUB")
    print("Введите желаемое количество альбомов для покупки: ")
    val amountMelodies = readLine()?.toUInt() ?: return
    val subTotal = PRICE_UNIT * amountMelodies
    print("Сумма ваших покупок в прошлый месяц?: ")
    val amountPreviousPeriod = readLine()?.toUInt() ?: return
    print("Вы постоянный клиент? y - да, n - нет.")
    val vipUser: Boolean
    val checkVipUser = readLine()
    vipUser = checkVipUser == "y"

    if (amountPreviousPeriod <= 1_000u && !vipUser) {
        totalAmount = subTotal
        print("$TEXT_AMOUNT_TO_BE_PAID $totalAmount $TEXT_RUB")
        return
    } else if (amountPreviousPeriod <= 1_000u && vipUser) {
        totalAmount = subTotal - (subTotal / 100u)
        println("$TEXT_AMOUNT_TO_BE_PAID $totalAmount $TEXT_RUB")
        return
    } else if (amountPreviousPeriod in 1_001u..10_000u && !vipUser) {
        totalAmount = subTotal - DISCOUNT_1LEVEL
        println("$TEXT_AMOUNT_TO_BE_PAID $totalAmount $TEXT_RUB")
        return
    } else if (amountPreviousPeriod in 1_001u..10_000u && vipUser) {
        subTotalVipUser = subTotal - DISCOUNT_1LEVEL
        totalAmount = subTotalVipUser - (subTotalVipUser / 100u)
        println("$TEXT_AMOUNT_TO_BE_PAID $totalAmount $TEXT_RUB")
        return
    } else if (amountPreviousPeriod > 10_000u && !vipUser) {
        totalAmount = subTotal - (subTotal * DISCOUNT_2LEVEL / 100u)
        println("$TEXT_AMOUNT_TO_BE_PAID $totalAmount $TEXT_RUB")
        return
    } else if (amountPreviousPeriod > 10_000u && vipUser) {
        subTotalVipUser = subTotal - (subTotal * DISCOUNT_2LEVEL / 100u)
        totalAmount = subTotalVipUser - (subTotalVipUser / 100u)
        println("$TEXT_AMOUNT_TO_BE_PAID $totalAmount $TEXT_RUB")
        return
    }
}






