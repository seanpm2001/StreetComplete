package de.westnordost.streetcomplete.quests.foot

import de.westnordost.streetcomplete.R
import de.westnordost.streetcomplete.data.osm.SimpleOverpassQuestType
import de.westnordost.streetcomplete.data.osm.changes.StringMapChangesBuilder
import de.westnordost.streetcomplete.data.osm.download.OverpassMapDataDao

class AddAccessibleForPedestrians(o: OverpassMapDataDao) : SimpleOverpassQuestType<Boolean>(o) {

    override val tagFilters = """
        ways with !foot and (
          sidewalk ~ none|no or
          sidewalk:both ~ none|no or
          (sidewalk:left ~ none|no and sidewalk:right ~ none|no)
        )
        and access !~ private|no
    """
    override val commitMessage = "Add whether roads are accessible for pedestrians"
    override val icon = R.drawable.ic_quest_pedestrian

    override fun getTitle(tags: Map<String, String>) = R.string.quest_accessible_for_pedestrians_title

    override fun createForm() = AddAccessibleForPedestriansForm()

    override fun applyAnswerTo(answer: Boolean, changes: StringMapChangesBuilder) {
        changes.add("foot", if(answer) "yes" else "no")
    }
}
