package com.alp.memorymatchwear.domain.usecase

import com.alp.memorymatchwear.domain.model.Card
import com.alp.memorymatchwear.domain.model.CardSymbol

class ShuffleBoardUseCase {
    /** Crea 12 tarjetas (2 de cada símbolo) mezcladas aleatoriamente. */
    operator fun invoke(): List<Card> =
        CardSymbol.values()
            .flatMap { symbol -> listOf(symbol, symbol) } // duplicar cada símbolo
            .shuffled()                                   // mezclar
            .mapIndexed { index, symbol ->                // asignar id
                Card(id = index, symbol = symbol)
            }
}
