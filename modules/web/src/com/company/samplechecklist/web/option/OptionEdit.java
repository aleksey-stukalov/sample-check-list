package com.company.samplechecklist.web.option;

import com.company.samplechecklist.web.optionsgroup.OptionsGroupEdit;
import com.haulmont.bali.util.ParamsMap;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.company.samplechecklist.entity.Option;
import com.haulmont.cuba.gui.components.FieldGroup;
import com.haulmont.cuba.gui.components.LookupPickerField;

import javax.inject.Inject;
import java.util.Map;

public class OptionEdit extends AbstractEditor<Option> {
    @Inject
    private FieldGroup fieldGroup;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);

        LookupPickerField field = (LookupPickerField) fieldGroup.getField("group").getComponent();
        field.getLookupAction().setLookupScreenParams(ParamsMap.of(OptionsGroupEdit.COMMAND_SHOW_OPTIONS_EDITOR, false));
    }
}