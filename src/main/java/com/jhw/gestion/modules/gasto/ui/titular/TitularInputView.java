package com.jhw.gestion.modules.gasto.ui.titular;

import com.jhw.swing.models.clean.CleanCRUDInputView;
import com.jhw.gestion.modules.gasto.ui.module.ContabilidadSwingModule;
import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import java.util.Map;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class TitularInputView extends CleanCRUDInputView<TitularDomain> {

    public TitularInputView() {
        this(null);
    }

    public TitularInputView(TitularDomain model) {
        super(model, ContabilidadSwingModule.titularUC, TitularDomain.class);
        initComponents();
        update();
    }

    private void initComponents() {
        setHeader("Crear Titular", "Editar Titular");

        //tipo
        textFieldnombre = new com.jhw.swing.material.components.textfield.validated._MaterialTextFieldStringNotEmpty();
        textFieldnombre.setLabel("Titular");
        textFieldnombre.setHint("Nombre del titilar");

        //descripcion
        textAreaDescripcion = new com.jhw.swing.material.components.textarea.prepared._MaterialTextAreaDescripcion();

        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder();
        vlc.add(textFieldnombre);

        vlc.add(textAreaDescripcion, true);
        this.setComponent(vlc.build());
    }

    // Variables declaration - do not modify
    private com.jhw.swing.material.components.textfield.validated._MaterialTextFieldStringNotEmpty textFieldnombre;
    private com.jhw.swing.material.components.textarea.prepared._MaterialTextAreaDescripcion textAreaDescripcion;
    // End of variables declaration                   

    @Override
    public Map<String, Object> bindFields() {
        Map<String, Object> bindFields = super.bindFields();
        bindFields.put("nombreTitular", textFieldnombre);
        bindFields.put("descripcion", textAreaDescripcion);
        return bindFields;
    }
}
