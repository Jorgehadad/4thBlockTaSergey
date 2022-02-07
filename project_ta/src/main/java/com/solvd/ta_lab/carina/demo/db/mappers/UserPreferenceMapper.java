package com.solvd.ta_lab.carina.demo.db.mappers;

import com.solvd.ta_lab.carina.demo.db.models.UserPreference;

public interface UserPreferenceMapper {

	void create(UserPreference userPreference);

	UserPreference findById(Long id);

}
