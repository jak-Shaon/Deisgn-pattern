//Adaptee class
class XML{
    public XML(String data){
        System.out.println(data);
    }
}

//Target class
class JSON{
    public JSON(String data){}

    XML convertToXml(){
        return new XML("JSON To XML conversion successfull");
    }
}

interface Adapter{
    XML convert(JSON json);
}

//Adapter class
class JsonToXml implements Adapter{
    private JSON json;
    
    public JsonToXml(JSON json){
        this.json=json;
    }

    @Override
    public XML convert(JSON json){
        return json.convertToXml();
    }
}

class Client{
    public static void main(String[] args) {
        JSON json= new JSON("Json Data");

        Adapter adapt = new JsonToXml(json);
        adapt.convert(json);
    }
}

