package com.jhw.gestion.modules.gasto.ui.tipo_gasto;

import com.jhw.gestion.modules.contabilidad.ui.forma_pago.FormaPagoICBS;
import com.jhw.gestion.modules.contabilidad.ui.tipo_operacion.TipoOperacionContableICBS;
import com.jhw.gestion.modules.gasto.core.domain.TipoGastoDomain;
import com.jhw.gestion.modules.gasto.ui.module.GastoSwingModule;
import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.models.clean.CleanCRUDInputView;
import java.util.Map;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class TipoGastoInputView extends CleanCRUDInputView<TipoGastoDomain> {

    public static TipoGastoInputView from() {
        return new TipoGastoInputView(null);
    }

    public static TipoGastoInputView fromModel(TipoGastoDomain model) {
        return new TipoGastoInputView(model);
    }

    private TipoGastoInputView(TipoGastoDomain model) {
        super(model, GastoSwingModule.tipoGastoUC, TipoGastoDomain.class);
        initComponents();
        update();
    }

    private void initComponents() {
        setHeader("Crear Tipo de gasto", "Editar Tipo de gasto");

        textFieldNombre = new com.jhw.swing.material.components.textfield._MaterialTextFieldIcon();
        textFieldNombre.setLabel("Nombre");
        textFieldNombre.setHint("Nombre del gasto");
        textFieldNombre.setIcon(MaterialIcons.PRIORITY_HIGH);

        monedaICBS = new com.jhw.gestion.modules.contabilidad.ui.moneda.MonedaICBS();
        monedaICBS.setLabel("Moneda por defecto");
        monedaICBS.setIcon(MaterialIcons.ATTACH_MONEY);

        tipoOpICBS = new TipoOperacionContableICBS();
        tipoOpICBS.setLabel("Operación contable por defecto");

        formaPagoICBS = new FormaPagoICBS();

        textAreaDescripcion = new com.jhw.swing.material.components.textarea.prepared._MaterialTextAreaDescripcion();

        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder();
        vlc.add(textFieldNombre);
        vlc.add(monedaICBS);
        vlc.add(tipoOpICBS);
        vlc.add(formaPagoICBS);
        vlc.add(textAreaDescripcion, true);

        this.setComponent(vlc.build());
    }

    // Variables declaration - do not modify
    private com.jhw.swing.material.components.textfield._MaterialTextFieldIcon textFieldNombre;
    private com.jhw.gestion.modules.contabilidad.ui.moneda.MonedaICBS monedaICBS;
    private TipoOperacionContableICBS tipoOpICBS;
    private FormaPagoICBS formaPagoICBS;
    private com.jhw.swing.material.components.textarea.prepared._MaterialTextAreaDescripcion textAreaDescripcion;
    // End of variables declaration                   

    @Override
    public Map<String, Object> bindFields() {
        Map<String, Object> map = super.bindFields();
        map.put("nombreGasto", textFieldNombre);
        map.put("monedaDefectoFk", monedaICBS);
        map.put("tipoOperacionContableDefectoFk", tipoOpICBS);
        map.put("formaPagoFk", formaPagoICBS);
        map.put("descripcion", textAreaDescripcion);
        return map;
    }

}
