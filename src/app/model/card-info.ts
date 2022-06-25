import {Doctor} from "./doctor";
import {Patient} from "./patient";

export class CardInfo {
  id: number;
  name: string;
  doctor: Doctor;
  patient: Patient;
  cardType: string;
}
