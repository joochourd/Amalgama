package domain.battle

import builder.ArmyBuilder
import builder.UnitBuilder
import domain.units.Archer
import domain.units.Knight
import domain.units.Pikemen
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class BattleResultTest {

    val unitBuilder = UnitBuilder()
    val builder = ArmyBuilder(unitBuilder)
    @Test
    fun strongestArmyWins() {
        //given
        val chineseArmy = builder.buildChineseArmy()
        val englishArmy = builder.buildEnglishArmy()
        val battlefield = Battlefield()

        //when
        battlefield.fight(chineseArmy, englishArmy)

        //then
        Assertions.assertEquals(chineseArmy.battleHistory.first(), englishArmy.battleHistory.first())
        Assertions.assertEquals(englishArmy.battleHistory.first().winner, englishArmy)
        Assertions.assertEquals(chineseArmy.battleHistory.first().loser, chineseArmy)

        val battleResult = chineseArmy.battleHistory.first()
        Assertions.assertEquals(battleResult.loserStrengh, 300)
        Assertions.assertEquals(battleResult.winnerStrengh, 350)

    }

    @Test
    fun ChineseWinsByTrainingUnits() {
        //given
        val chineseArmy = builder.buildChineseArmy()
        val englishArmy = builder.buildEnglishArmy()
        val battlefield = Battlefield()
        val firstKnight = chineseArmy.units.first { it is Knight }

        //when
        repeat(20) {
            chineseArmy.trainUnit(firstKnight.id)
        }
        battlefield.fight(chineseArmy, englishArmy)

        //then
        val battle = englishArmy.battleHistory.first()
        Assertions.assertEquals(battle.winner, chineseArmy)
        Assertions.assertEquals(battle.winnerStrengh, 360)
        Assertions.assertEquals(battle.loserStrengh, 350)

    }

    @Test
    fun ChineseWinsByTransformingUnits() {
        //given
        val chineseArmy = builder.buildChineseArmy()
        val englishArmy = builder.buildEnglishArmy()
        val battlefield = Battlefield()

        //when
        repeat(2) {
            val pikemen = chineseArmy.units.first{it is Pikemen } as Pikemen
            chineseArmy.transformUnit(pikemen)
        }
        repeat(5) {
            val archer = chineseArmy.units.first{it is Archer } as Archer
            chineseArmy.transformUnit(archer)
        }
        battlefield.fight(chineseArmy, englishArmy)

        //then
        val battle = englishArmy.battleHistory.first()

        Assertions.assertEquals(battle.loserStrengh, 350)
        Assertions.assertEquals(battle.winnerStrengh, 360)
        Assertions.assertEquals(battle.winner, chineseArmy)
    }

}

