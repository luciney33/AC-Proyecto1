package newspaperoot.dao.utilities;

public class Queries {
    public static final String SelectFrom = "select a.id_article, a.name_article, a.id_newspaper,t.id_type as id_type,t.name, t.description as description " +
            "from Article a join Type t on a.id_type = t.id_type";
    public static final String SelectGet = "select a.id_article, a.name_article, a.id_newspaper,t.id_type as type_id, t.description as type_description " +
            "from Article a join Type t on a.id_type = t.id_type where a.id_article = ?";
    public static final String SelectSave = "insert into Article (name_article, id_newspaper, id_type) values (?, ?, ?)";
    public static final String Delete = "delete from Article where id_article = ?";
    public static final String Update = "update Article set name_article = ? where id_article = ?";
    public static final String SelectFromCrede = "select * from Credentials";
    public static final String SelectGetCrede = "select username, password, id_reader from Credentials where username = ?";

    public static final String SelectFromNews = "select * from Newspaper";
    public static final String SelectFromReader = "select * from Reader";
    public static final String SelectNewRating = "insert into ReadActivity rating values ?";

    public static final String SelectReaderID = "select * from Reader where id_reader = ?";

    public static final String SelectReaderACT = "select ra.id_reader, ra.id_article, r.name, r.birth_date, s.id_newspaper, ra.rating from ReadActivity ra join Reader r on ra.id_reader = r.id_reader"+
            " join Subscription s on r.id_reader = s.id_reader where ra.id_article = ? group by ra.id_reader, ra.id_article, r.name, r.birth_date, ra.rating, s.id_newspaper";

    public static final String SelectFromType = "select * from Type";

}
