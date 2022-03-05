import kotlin.system.exitProcess

const val PRICE_UNIT = 1000u
const val DISCOUNT_1LV = 10u
const val DISCOUNT_2LV = 5u

fun main() {
    val amountPriceUser: UInt
    val amountPriceUser2lv: UInt
    val amountPriceVipUser: UInt

    println("Добро пожаловать в магазин музыкальных альбомов МЕЛОДИЯ !")
    println("Стоимость одного альбома $PRICE_UNIT руб.")
    print("Введите желаемое количество альбомов для покупки: ")
    val amountMelodies = readLine()?.toUInt() ?: return

    print("Сумма ваших покупок в прошлый месяц?: ")
    val amountPreviousPeriod = readLine()?.toUInt() ?: return

    if (amountPreviousPeriod <= 1_000u) {
        amountPriceUser = (PRICE_UNIT * amountMelodies)
        print("Сумма к оплате $amountPriceUser руб.")
        exitProcess(0)
    } else if (amountPreviousPeriod in 1_001u..10_000u) {
        amountPriceUser = ((PRICE_UNIT * amountMelodies) - DISCOUNT_1LV)
        println("Сумма к оплате: $amountPriceUser руб., скидка составила: $DISCOUNT_1LV руб. ")
        exitProcess(0)
    } else {
        print("Вы постоянный клиент? y - да, n - нет.")
    }
    val vipUser: Boolean
    val checkVipUser = readLine()
    vipUser = checkVipUser == "y"

    if (amountPreviousPeriod > 10_000u && !vipUser) {
        val discountUser = ((PRICE_UNIT * amountMelodies) * DISCOUNT_2LV / 100u)
        amountPriceUser2lv = (PRICE_UNIT * amountMelodies) - discountUser
        print("Сумма к оплате: $amountPriceUser2lv руб., скидка составила: $discountUser руб. ")

    } else if (amountPreviousPeriod > 10_000u && vipUser) {
        val discountVipUser =
            ((PRICE_UNIT * amountMelodies) * DISCOUNT_2LV / 100u) + ((PRICE_UNIT * amountMelodies) / 100u)
        amountPriceVipUser = (PRICE_UNIT * amountMelodies) - discountVipUser
        print("Сумма к оплате: $amountPriceVipUser руб., скидка составила: $discountVipUser руб. ")
    }
}






