import {Doctor} from "./doctor";
import {Patient} from "./patient";

export class CardInfo {
  id: number | undefined;
  name: string | undefined;
  doctor: Doctor | undefined;
  patient: Patient | undefined;
  cardType: string | undefined;
}
