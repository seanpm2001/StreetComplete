package de.westnordost.streetcomplete.quests.motorcycle_parking_capacity

import android.os.Bundle
import android.view.View
import de.westnordost.streetcomplete.R
import de.westnordost.streetcomplete.quests.AbstractQuestFormAnswerFragment
import de.westnordost.streetcomplete.util.TextChangedWatcher
import kotlinx.android.synthetic.main.quest_motorcycle_parking_capacity.*

class AddMotorcycleParkingCapacityForm : AbstractQuestFormAnswerFragment<Int>() {

    override val contentLayoutResId = R.layout.quest_motorcycle_parking_capacity

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        capacityInput.addTextChangedListener(TextChangedWatcher { checkIsFormComplete() })
    }

    override fun isFormComplete() = capacityInput.text.trim().toString().isNotEmpty()

    override fun onClickOk() {
        applyAnswer(capacityInput.text.trim().toString().toInt())
    }
}
