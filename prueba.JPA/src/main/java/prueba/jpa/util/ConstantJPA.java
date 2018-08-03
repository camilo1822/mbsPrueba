package prueba.jpa.util;

public class ConstantJPA {

    private ConstantJPA() {
    }

    // Fields
    public static final String COMMON_STRING_JOIN = "tipoParametro";
    public static final String COMMON_STRING_TIPO_PARAMETRO_ID = "tipoParametroId";
    public static final String COMMON_STRING_TIPO_COUNTRY_ID = "countryId";
    public static final String COMMON_STRING_ORDER = "orden";
    public static final String DATABASE_OPERATION_ERROR = "[DATABASE OPERATION ERROR]:";
    public static final String COMMON_STRING_CUSTOMER_ID = "customerId";
    public static final String COMMON_STRING_CARD_ID = "cardId";
    public static final String COMMON_STRING_COUNTRY = "divisionGeografica";
    public static final String COMMON_STRING_COUNTRY_CODE = "codigoDivision";

    // Queries & Parameters
    public static final String QUERY_CLIENTE_BY_PHONENUMBER = "Cliente.findByPhoneNumber";
    public static final String COMMON_PARAMETER_PHONENUMBER = "phoneNumber";
    public static final String COMMON_STRING_SHBANCA_DIGITAL = "SHBANCA_DIGITAL";
    public static final String COMMON_STRING_ENTITY_CLIENTE = "CLIENTE";
    public static final String COMMON_STRING_ENTITY_PARAMETRO = "PARAMETRO";
    public static final String COMMON_STRING_ENTITY_TIPO_PARAMETRO = "TIPO_PARAMETRO";
    public static final String COMMON_STRING_ENTITY_TARJETA_VIRTUAL = "TARJETA_VIRTUAL";
    public static final String COMMON_STRING_ENTITY_DIVISION_GEOGRAFICA = "DIVISION_GEOGRAFICA";
    public static final String QUERY_PARAMETER_BY_REGION = "Parametro.getRegionParameter";

    // Methods
    public static final String COMMON_STRING_GET_CLIENT_PHONENUMBER_METHOD = ":getClientByPhoneNumber:";
    public static final String COMMON_STRING_PERSIST_VIRTUAL_CARD_METHOD = ":persistVirtualCard:";
    public static final String COMMON_STRING_GET_VIRTUAL_CARD_METHOD = ":getVirtualCard:";
    public static final String COMMON_STRING_MERGE_VIRTUAL_CARD_METHOD = ":mergeVirtualCard:";
    public static final String COMMON_STRING_GET_PARAMETER_METHOD = ":getParameterValue:";

    // Query
    public static final String NAMED_QUERY_TARJETA_VIRTUAL_GET_CARD_NAME = "TarjetaVirtual.getVirtualCard";
    public static final String NAMED_QUERY_TARJETA_VIRTUAL_GET_CARD_QUERY = "SELECT t FROM TarjetaVirtual t WHERE t.tarjetaId = :cardId AND t.cliente.clienteId = :customerId";
    public static final String NAMED_QUERY_DIVISION_GEOGRAFICA_FIND_ALL = "DivisionGeografica.findAll";
    public static final String NAMED_QUERY_DIVISION_GEOGRAFICA_SELECT_ALL = "SELECT d FROM DivisionGeografica d";
    public static final String NAMED_QUERY_TIPO_PARAMETRO_FIND_ALL = "TipoParametro.findAll";
    public static final String NAMED_QUERY_TIPO_PARAMETRO_SELECT_ALL = "SELECT t FROM TipoParametro t";
    public static final String NAMED_QUERY_PARAMETRO_GET_PARAMETER_BY_REGION = "SELECT p FROM Parametro p WHERE p.tipoParametro.tipoParametroId = :tipoParametroId and p.divisionGeografica.codigoDivision = :countryId";

    // Values
    public static final String COMMON_STRING_NEQUI_UPPER = "NEQUI";

}
